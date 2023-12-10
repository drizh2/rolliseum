import { ToolFeature } from "./tool-feature";
export class Tool {

    constructor(public id: number,
                public name: string,
                public cost: number,
                public toolFeatures: Array<ToolFeature>) {}
    
}
