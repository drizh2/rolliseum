import { WeaponTypes } from "./enum/weapon-types";
export class Weapon {

    constructor(public id: number,
                public name: string,
                public types: Array<WeaponTypes>,
                public range: string,
                public attackBonus: number,
                public damage: number,
                public damageType: string) {}

}
