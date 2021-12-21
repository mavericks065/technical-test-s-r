import React from 'react'
import {Character} from "../Character";

export const Characters = (characters: Array<Character>) => {

    console.log('characters length:::', characters.length)
    if (characters.length === 0) return null

    const characterRow = (character: any, index: number) => {

        return(
            <tr key = {index} className={index%2 === 0?'odd':'even'}>
                <td>{character.id}</td>
                <td>{character.name}</td>
                <td>{character.homeworld}</td>
                <td>{character.votes}</td>
            </tr>
        )
    }

    const characterTable = characters.map((character: any, index: number) => characterRow(character,index))

    return(
        <div className="container">
            <h2>characters</h2>
            <table className="table table-bordered">
                <thead>
                <tr>
                    <th>character Id</th>
                    <th>name</th>
                    <th>homeworld</th>
                    <th>votes</th>
                </tr>
                </thead>
                <tbody>
                {characterTable}
                </tbody>
            </table>
        </div>
    )
}
