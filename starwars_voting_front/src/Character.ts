export class Character {
    name: string
    homeworld: string
    votes: number
    id: number

    constructor(name: string, homeworld: string, votes: number, id: number) {
        this.name = name;
        this.homeworld = homeworld;
        this.votes = votes;
        this.id = id;
    }
}
