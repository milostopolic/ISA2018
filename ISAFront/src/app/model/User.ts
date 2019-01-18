export class User { 
    id: number;
    email: string;
    password: string;
    name: string;
    surname: string;
    city: string;
    phoneNmbr: string;
    verified: boolean; 
    friends: Array<User>;
    pending: Array<User>;
    suggested: Array<User>;
  }