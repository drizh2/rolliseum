import { Components } from "./enum/components";
export class Spell {

    constructor(public id: number,
                public name: string,
                public time: string,
                public distance: string,
                public duration: string,
                public components: Array<Components>,
                public caption: string) {}

}
