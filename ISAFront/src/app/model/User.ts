export class User { 
    id: number;
    email: string;
    username: string;
    password: string;
    
    name: string;
    surname: string;
    city: string;
    phoneNmbr: string;
    verified: boolean; 
    role : string;
    friends: Array<User>;
    pending: Array<User>;
    suggested: Array<User>;
  }