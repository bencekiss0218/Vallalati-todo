import { UserRole } from './user-role';
import { Task } from './task';
import { TaskComment } from './task-comment';

export interface User {
    name: string;
    username: string;
    password: string;
    role: UserRole;
    taskToDo: Task[];
    comments: TaskComment[];
}
