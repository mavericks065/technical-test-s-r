import {Character} from "../Character";

export class CharactersService {
    public async getCharacters(): Promise<Array<Character>> {
        const response = await fetch('/characters');
        return await response.json();
    }
}
