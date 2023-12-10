import { Races } from "./enum/races";
import { Feature } from "./feature";
import { SkillIncrement } from "./skill-increment";

export class Race {
    
    constructor(public id: number,
                public name: Races,
                public type: string,
                public stats: Array<SkillIncrement>,
                public size: string,
                public speed: number,
                public raceFeatures: Array<Feature>,
                public languages: Array<string>) {}

}
