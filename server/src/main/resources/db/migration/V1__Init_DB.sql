create table background_equip (
                                  background_id bigint not null,
                                  equip varchar(255)
) engine=InnoDB;

create table background_languages (
                                      background_id bigint not null,
                                      languages varchar(255)
) engine=InnoDB;

create table background_skills (
                                   background_id bigint not null,
                                   skills varchar(255)
) engine=InnoDB;

create table background_stats (
                                  background_id bigint not null,
                                  stats varchar(255)
) engine=InnoDB;

create table backgrounds (
                             id bigint not null auto_increment,
                             caption text not null,
                             name varchar(255) not null,
                             primary key (id)
) engine=InnoDB;

create table character_treasures (
                                     character_id bigint not null,
                                     treasures varchar(255)
) engine=InnoDB;

create table characters (
                            age integer,
                            armor_class integer,
                            current_hit_points integer,
                            height integer,
                            level integer not null,
                            temporary_hit_points integer,
                            total_hit_dice integer,
                            weight integer,
                            background_id bigint,
                            charisma_stat_id bigint,
                            clas_id bigint,
                            constitution_stat_id bigint,
                            creation_date datetime(6),
                            dexterity_stat_id bigint,
                            id bigint not null auto_increment,
                            intelligence_stat_id bigint,
                            race_id bigint,
                            strength_stat_id bigint,
                            subclass_id bigint,
                            user_id bigint,
                            wisdom_stat_id bigint,
                            alignment varchar(255),
                            appearance text,
                            backstory text,
                            bonds text,
                            eyes varchar(255),
                            flaws text,
                            hair varchar(255),
                            ideals text,
                            name varchar(255) not null,
                            personalty_traits text,
                            player_name varchar(255),
                            skin varchar(255),
                            primary key (id)
) engine=InnoDB;

create table characters_spells (
                                   character_id bigint not null,
                                   spells_id bigint not null
) engine=InnoDB;

create table characters_weapons (
                                    character_id bigint not null,
                                    weapons_id bigint not null
) engine=InnoDB;

create table classes (
                         count_of_stats integer not null,
                         first_level_hits integer not null,
                         hit_dice integer not null,
                         name tinyint not null,
                         next_level_hits integer not null,
                         spell_saving_throw integer not null,
                         id bigint not null, armor varbinary(255),
                         primary key (id)
) engine=InnoDB;

create table classes_seq (
    next_val bigint
) engine=InnoDB;

insert into classes_seq values (
                                   1
                               );

create table classes_tools (
                               class_id bigint not null,
                               tools_id bigint not null
) engine=InnoDB;

create table features (
                          class_level integer,
                          subclass_level integer,
                          class_id bigint,
                          id bigint not null auto_increment,
                          race_id bigint,
                          subclass_id bigint,
                          content text,
                          name varchar(255) not null,
                          primary key (id)
) engine=InnoDB;

create table image_model (
                             character_id bigint,
                             id bigint not null auto_increment,
                             user_id bigint,
                             name varchar(255) not null,
                             image_bytes LONGBLOB,
                             primary key (id)
) engine=InnoDB;

create table race_languages (
                                race_id bigint not null,
                                languages varchar(255)
) engine=InnoDB;

create table races (
                       name tinyint not null,
                       speed integer not null,
                       id bigint not null auto_increment,
                       size varchar(255) not null,
                       type varchar(255) not null,
                       primary key (id)
) engine=InnoDB;

create table races_stats (
                             race_id bigint not null,
                             stats_id bigint not null
) engine=InnoDB;

create table skill_increments (
                                  modificator integer not null,
                                  id bigint not null auto_increment,
                                  name varchar(255) not null,
                                  primary key (id)
) engine=InnoDB;

create table spell_component (
                                 components tinyint,
                                 spell_id bigint not null
) engine=InnoDB;

create table spells (
                        id bigint not null auto_increment,
                        caption text,
                        distance varchar(255) not null,
                        duration varchar(255) not null,
                        name varchar(255),
                        time varchar(255) not null,
                        primary key (id)
) engine=InnoDB;

create table spells_classes (
                                classes_id bigint not null,
                                spell_id bigint not null
) engine=InnoDB;

create table spells_races (
                              races_id bigint not null,
                              spell_id bigint not null
) engine=InnoDB;

create table statistic_skills (
                                  skills bit,
                                  statistic_id bigint not null,
                                  skills_key varchar(255) not null,
                                  primary key (statistic_id, skills_key)
) engine=InnoDB;

create table statistics (
                            modificator integer not null,
                            saving_throw bit,
                            id bigint not null auto_increment,
                            name varchar(255) not null,
                            primary key (id)
) engine=InnoDB;

create table subclasses (
                            class_id bigint,
                            id bigint not null auto_increment,
                            name varchar(255) not null,
                            primary key (id)
) engine=InnoDB;

create table tool_features (
                               id bigint not null auto_increment,
                               tool_id bigint,
                               content text not null,
                               name varchar(255) not null,
                               primary key (id)
) engine=InnoDB;

create table tools (
                       cost integer,
                       id bigint not null auto_increment,
                       name varchar(255) not null,
                       primary key (id)
) engine=InnoDB;

create table user_role (
                           roles tinyint,
                           user_id bigint not null
) engine=InnoDB;

create table users (
                       creation_date datetime(6),
                       id bigint not null auto_increment,
                       password varchar(3000) not null,
                       activation_code varchar(255),
                       email varchar(255) not null,
                       username varchar(255) not null,
                       primary key (id)
) engine=InnoDB;

create table weapons (
                         attack_bonus integer not null,
                         damage integer not null,
                         id bigint not null auto_increment,
                         damage_type varchar(255),
                         farness varchar(255) not null,
                         name varchar(255) not null,
                         types varbinary(255) not null,
                         primary key (id)
) engine=InnoDB;

create table class_armor (
    class_id bigint not null,
    armor enum ('ALL','HEAVY','LIGHT','MEDIUM','NONE','SHIELDS')
                         ) engine=InnoDB;

create table class_saving_throws (
    class_id bigint not null,
    saving_throws enum ('CHARISMA','CONSTITUTION','DEXTERITY','INTELLIGENCE','STRENGTH','WISDOM')
                                 ) engine=InnoDB;

create table class_skills (
    class_id bigint not null,
    skills enum ('ACROBATICS','ANIMAL_HANDLING','ARCANA','ATHLETICS','DECEPTION','HISTORY','INSIGHT','INTIMIDATION','INVESTIGATION','MEDICINE','NATURE','PERCEPTION','PERFORMANCE','PERSUASION','RELIGION','SLEIGHT_OF_HAND','STEALTH','SURVIVAL')
                          ) engine=InnoDB;

create table class_weapons (
    class_id bigint not null,
    weapons enum ('AXES','BOWS','CROSSBOWS','DAGGERS','EXOTIC','FIST','GUNS','HAND_TO_HAND','LONG_RANGE','MACES','OFF_HAND','POLEARMS','RELICS','SIMPLE','STAVES','SWORDS','THROWN','WANDS','WARGLAIVES','WARRIORS')
                           ) engine=InnoDB;

create table weapon_types (
    weapon_id bigint not null,
    weapon_types enum ('AXES','BOWS','CROSSBOWS','DAGGERS','EXOTIC','FIST','GUNS','HAND_TO_HAND','LONG_RANGE','MACES','OFF_HAND','POLEARMS','RELICS','SIMPLE','STAVES','SWORDS','THROWN','WANDS','WARGLAIVES','WARRIORS') not null
                          ) engine=InnoDB;

alter table backgrounds
    add constraint UK_powqmmgqw803e22f9ypax3mrn unique (name);

alter table characters
    add constraint UK_dfnaa8tgg0yhi0ytt67q6797c unique (charisma_stat_id);

alter table characters
    add constraint UK_htwhmld78da601sfgj3qjfnec unique (constitution_stat_id);

alter table characters
    add constraint UK_8ly0xuo4hn31cv6kmvhkfoywa unique (dexterity_stat_id);

alter table characters
    add constraint UK_atfotqyhh46o2r7cl2wy7m5i3 unique (intelligence_stat_id);

alter table characters
    add constraint UK_9vtmfysycpvb9pw6c0b65ofvf unique (strength_stat_id);

alter table characters
    add constraint UK_eibrbqrjafb2aidn9mvja6m8q unique (wisdom_stat_id);

alter table classes
    add constraint UK_pgs3gcxax70h9jugbt24ugwcg unique (name);

alter table features
    add constraint UK_b6qhwd2ah4bi6b4dlaflberpm unique (name);

alter table races
    add constraint UK_eesutvgpcjgk3lmit0o4k4ad unique (name);

alter table spells
    add constraint UK_pqhvtuti6ps3c2qdblx1297wu unique (name);

alter table subclasses
    add constraint UK_ilsafqe8xt91b4fydja3r12hn unique (name);

alter table tool_features
    add constraint UK_se1i6ljwobxv407nuflxh81u0 unique (name);

alter table tools
    add constraint UK_gn1w3u49lbxxmtqrjfkcn9g3u unique (name);

alter table users
    add constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username);

alter table weapons
    add constraint UK_5ghesrxjlp5o610ctxrfd3tpo unique (name);

alter table background_equip
    add constraint FK6l7jqd2xb7ye9qedhl15rfit4
        foreign key (background_id)
            references backgrounds (id);

alter table background_languages
    add constraint FKr5g7ma603f6f4pdnb0txat62x
        foreign key (background_id)
            references backgrounds (id);

alter table background_skills
    add constraint FK2geolxjck45s8yow8oppg0fhs
        foreign key (background_id)
            references backgrounds (id);

alter table background_stats
    add constraint FK5e2addn07m9c52h2af3gish69
        foreign key (background_id)
            references backgrounds (id);

alter table character_treasures
    add constraint FKmir17pyl2egt2dyer7jrnk6cp
        foreign key (character_id)
            references characters (id);

alter table characters
    add constraint FK9scwe93vcuyoy1qyai19c4mvi
        foreign key (background_id)
            references backgrounds (id);

alter table characters
    add constraint FK2vh5fn9pcu5h6219dwps7vyqp
        foreign key (charisma_stat_id)
            references statistics (id);

alter table characters
    add constraint FKdw1px9pu4oexf801fhblvv5ls
        foreign key (clas_id)
            references classes (id);

alter table characters
    add constraint FKhmtmg3hxvmxsgxa5k8ylhkqyl
        foreign key (constitution_stat_id)
            references statistics (id);

alter table characters
    add constraint FK6dfth2ekh6ljmc415suclebfh
        foreign key (dexterity_stat_id)
            references statistics (id);

alter table characters
    add constraint FK1q64hf325gsfb6vxgypoxpnj9
        foreign key (intelligence_stat_id)
            references statistics (id);

alter table characters
    add constraint FKo6gm7oj0xscb6p54jaswr8sb6
        foreign key (race_id)
            references races (id);

alter table characters
    add constraint FKbrh8waxeoyx9baabm5c0wdosp
        foreign key (strength_stat_id)
            references statistics (id);

alter table characters
    add constraint FKqam8hxt8166r66700wfw6hfg0
        foreign key (subclass_id)
            references subclasses (id);

alter table characters
    add constraint FK27yx743bsnnsqplnjhk5yf224
        foreign key (user_id)
            references users (id);

alter table characters
    add constraint FKjkm9gfbsmg5an0qw5l8ms8uoi
        foreign key (wisdom_stat_id)
            references statistics (id);

alter table characters_spells
    add constraint FK86jgr9l42a2thcwgfjfht1ay3
        foreign key (spells_id)
            references spells (id);

alter table characters_spells
    add constraint FKd0uo5h0xl0xqj3icpfwwh0jf4
        foreign key (character_id)
            references characters (id);

alter table characters_weapons
    add constraint FK4eqilcrqu4do0kjibjyk1two5
        foreign key (weapons_id)
            references weapons (id);

alter table characters_weapons
    add constraint FKbvw08rgm6oje6flllpg29stel
        foreign key (character_id)
            references characters (id);

alter table classes_tools
    add constraint FKd9og7hm8ipk6r2meteb3wfngp
        foreign key (tools_id)
            references tools (id);

alter table classes_tools
    add constraint FKlqlcf0j25lrtx2wc9lig8nyi1
        foreign key (class_id)
            references classes (id);

alter table features
    add constraint FKspaxvn4oij8kow4ebsf47ihln
        foreign key (class_id)
            references classes (id);

alter table features
    add constraint FKgrhnf3spal8ubgpxdsc8j70xv
        foreign key (race_id)
            references races (id);

alter table features
    add constraint FKn2f1ey2uby8vh1wpxq8c79fxt
        foreign key (subclass_id)
            references subclasses (id);

alter table race_languages
    add constraint FK8677mx86ym4jn0hou9uknbyf3
        foreign key (race_id)
            references races (id);

alter table races_stats
    add constraint FK4oipc6ij99b5mssgnd0blbchm
        foreign key (stats_id)
            references skill_increments (id);

alter table races_stats
    add constraint FKtk6m57epjlhaqqg4uw5nk18wr
        foreign key (race_id)
            references races (id);

alter table spell_component
    add constraint FK2diq80wfuiyjqwc2m37dg9r4i
        foreign key (spell_id)
            references spells (id);

alter table spells_classes
    add constraint FK1qmasf3qn29m1g5te6g7bd1m1
        foreign key (classes_id)
            references classes (id);

alter table spells_classes
    add constraint FKki90o6l8ffebkqewhsbrxau6d
        foreign key (spell_id)
            references spells (id);

alter table spells_races
    add constraint FK1kqm7irgtvhvemdatjuntk7vr
        foreign key (races_id)
            references races (id);

alter table spells_races
    add constraint FKsik8q8lqtowpo0sjp7nu1uvbf
        foreign key (spell_id)
            references spells (id);

alter table statistic_skills
    add constraint FKoxnc301s1rp9bqvohuqtev0ba
        foreign key (statistic_id)
            references statistics (id);

alter table subclasses
    add constraint FK1ujvx7anu7f39v417795bnm54
        foreign key (class_id)
            references classes (id);

alter table tool_features
    add constraint FKqxteks5pome290w42asp47liv
        foreign key (tool_id)
            references tools (id);

alter table user_role
    add constraint FKj345gk1bovqvfame88rcx7yyx
        foreign key (user_id)
            references users (id);

alter table class_armor
    add constraint FKb0ya5m50c50nmu7o0obnx3200
        foreign key (class_id)
            references classes (id);

alter table class_saving_throws
    add constraint FKpa6qu26kr3u732t4x3hbuxvvc
        foreign key (class_id)
            references classes (id);

alter table class_skills
    add constraint FK6k5ic5nkff22sh20j3k4kbuph
        foreign key (class_id)
            references classes (id);

alter table class_weapons
    add constraint FK664rih4aq5uppuis6367icw4d
        foreign key (class_id)
            references classes (id);

alter table weapon_types
    add constraint FKbw9iwhxjjc7ournhxqdvdl2xv
        foreign key (weapon_id)
            references weapons (id);