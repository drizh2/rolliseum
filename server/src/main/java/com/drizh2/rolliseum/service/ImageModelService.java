package com.drizh2.rolliseum.service;

import com.drizh2.rolliseum.entity.Character;
import com.drizh2.rolliseum.entity.ImageModel;
import com.drizh2.rolliseum.entity.User;
import com.drizh2.rolliseum.repository.ImageRepository;
import com.drizh2.rolliseum.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@Service
public class ImageModelService {

    public static final Logger LOG = LoggerFactory.getLogger(ImageModelService.class);

    private final ImageRepository imageRepository;
    private final UserRepository userRepository;

    @Autowired
    public ImageModelService(ImageRepository imageRepository, UserRepository userRepository) {
        this.imageRepository = imageRepository;
        this.userRepository = userRepository;
    }

    public ImageModel uploadImageToUser(MultipartFile file, Principal principal) throws IOException {
        User user = getUserByPrincipal(principal);
        LOG.info("Uploading image to user {}", user.getUsername());

        ImageModel userImage = imageRepository.findImageModelByUserId(user.getId()).orElse(null);

        if (!ObjectUtils.isEmpty(userImage)) {
            imageRepository.delete(userImage);
        }

        ImageModel imageModel = new ImageModel();
        imageModel.setUserId(user.getId());
        imageModel.setImageBytes(compressBytes(file.getBytes()));
        imageModel.setName(file.getOriginalFilename());

        return imageRepository.save(imageModel);
    }

    public ImageModel uploadImageToCharacter(MultipartFile file, Principal principal, Long characterId) throws IOException {
        User user = getUserByPrincipal(principal);
        Character character = user.getCharacters()
                .stream()
                .filter(c -> c.getId().equals(characterId))
                .collect(toSingleCharacterCollector());

        ImageModel imageModel = new ImageModel();
        imageModel.setCharacterId(characterId);
        imageModel.setImageBytes(compressBytes(file.getBytes()));
        imageModel.setName(file.getOriginalFilename());

        LOG.info("Uploading image profile to Character {}", character.getName());

        return imageRepository.save(imageModel);
    }

    public ImageModel getImageToUser(Principal principal) {
        User user = getUserByPrincipal(principal);

        ImageModel imageModel = imageRepository.findImageModelByUserId(user.getId())
                .orElse(null);

        if (!ObjectUtils.isEmpty(imageModel)) {
            imageModel.setImageBytes(decompressBytes(imageModel.getImageBytes()));
        }

        return imageModel;
    }

    public ImageModel getImageToCharacter(Long characterId) {
        ImageModel imageModel = imageRepository.findImageModelByCharacterId(characterId)
                .orElse(null);

        if (!ObjectUtils.isEmpty(imageModel)) {
            imageModel.setImageBytes(decompressBytes(imageModel.getImageBytes()));
        }

        return imageModel;
    }

    private byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            LOG.error("Cannot compress bytes");
        }
        LOG.info("Compressed Image Byte Size - {}", outputStream.toByteArray().length);
        return outputStream.toByteArray();
    }

    private static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException | DataFormatException e) {
            LOG.error("Cannot decompress Bytes");
        }
        return outputStream.toByteArray();
    }

    private <T> Collector<T, ?, T> toSingleCharacterCollector() {
        return Collectors.collectingAndThen(
                Collectors.toList(),
                list -> {
                    if (list.size() != 1) {
                        throw new IllegalStateException();
                    }
                    return list.get(0);
                }
        );
    }

    private User getUserByPrincipal(Principal principal) {
        String username = principal.getName();
        return userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User was not found"));
    }

}
