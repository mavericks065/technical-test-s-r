import React, {useEffect, useState} from 'react';
import './App.css';
import {Characters} from './components/Characters';
import {CharactersService} from "./services/CharactersService";
import {Character} from "./Character";

const defaultCharacters = new Array<Character>()

function App() {
  const [characters, setCharacters] = useState<Array<Character>>(defaultCharacters);

  const service = new CharactersService();

  useEffect( () => {
    async function getCharacters(): Promise<void> {
      const characters = await service.getCharacters();
      console.log('response');
      console.log(characters);
      setCharacters(characters);
    }
    getCharacters()
  }, [characters])

  return (
    <div className="App">
      <Characters characters={characters} />
    </div>
  );
}

export default App;
