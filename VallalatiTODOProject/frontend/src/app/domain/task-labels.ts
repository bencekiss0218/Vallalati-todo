import { Task } from './task';

export interface TaskLabel {
    text: string;
    body: string;
    tasks: Task[];
}
