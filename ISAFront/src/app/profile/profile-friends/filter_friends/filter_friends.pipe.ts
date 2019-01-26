import { Pipe, PipeTransform } from '@angular/core';
import { User } from 'src/app/model/User';

@Pipe({name: "filter_friends"})

export class Filter_friends_pipe implements PipeTransform{
    transform(friends_list : User[], typed : string) : User[]{
        return friends_list.filter(friend => friend.name.toLowerCase().includes(typed.toLowerCase()) || friend.surname.toLowerCase().includes(typed.toLowerCase()));
    }
}