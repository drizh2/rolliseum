import { Skills } from "./enum/skills";
export class Statistic {

    constructor(public id: number,
                public name: string,
                public modificator: number,
                public savingThrow: boolean,
                public skills: Array<Skills>) {}

}
