import { Identifiable } from "./Identifiable";
import { Role } from  "./Role"

export interface User extends Identifiable {
	id: number;
	firstName: string;
	lastName: string;
	email: string;
	username: string;
	password: string;
	displayName: string;
	roles: Role[];
}
