import { ArmorTypes } from "./enum/armor-types";
import { Classes } from "./enum/classes";
import { SavingThrows } from "./enum/saving-throws";
import { Skills } from "./enum/skills";
import { WeaponTypes } from "./enum/weapon-types";
import { Feature } from "./feature";
import { Subclass } from "./subclass";
import { Tool } from "./tool";

export class Class {

    constructor(public id: number,
                public name: Classes,
                public hitDice: number,
                public firstLevelHits: number,
                public nextLevelHits: number,
                public subclasses: Array<Subclass>,
                public features: Array<Feature>,
                public armor: Array<ArmorTypes>,
                public weapons: Array<WeaponTypes>,
                public tools: Array<Tool>,
                public savingThrows: Array<SavingThrows>,
                public skills: Array<Skills>,
                public countOfStats: number,
                public spellSavingThrow: number) {}

}
