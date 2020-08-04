export class Feature {
    id?: number;
    displayName?: string;
    technicalName: string;
    expiresOn?: any;
    description?: string;
    inverted: boolean;
    customerIds: Array<string>;
}