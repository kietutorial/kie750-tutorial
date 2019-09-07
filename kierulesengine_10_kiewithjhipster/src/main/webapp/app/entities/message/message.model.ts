import { BaseEntity } from './../../shared';

export const enum StatusType {
    'HELLO',
    'GOODBYE'
}

export class Message implements BaseEntity {
    constructor(
        public id?: number,
        public message?: string,
        public status?: StatusType,
    ) {
    }
}
