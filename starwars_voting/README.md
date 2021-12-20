# Star Wars characters' voting backend 

### How to run the application?

1. Run docker compose `docker-compose -f docker/docker-compose.yml -p starwars_voting up` to run redis
2. Run the springboot application with the `dev` spring profile
3. Go to `http://localhost:8080/swagger-ui.html` to play with the API



### To insert the characters: 
```
hset characters:starwars:1 "id" 1 "name" "Luke Skywalker" "pic" "https://vignette.wikia.nocookie.net/starwars/images/2/20/LukeTLJ.jpg" "homeworld" "tatooine"
hset characters:starwars:2 "id" 2 "name" "C-3PO" "pic" "https://vignette.wikia.nocookie.net/starwars/images/3/3f/C-3PO_TLJ_Card_Trader_Award_Card.png" "homeworld" "tatooine"
hset characters:starwars:3 "id" 3 "name" "R2-D2" "pic" "https://vignette.wikia.nocookie.net/starwars/images/e/eb/ArtooTFA2-Fathead.png" "homeworld" "naboo"
hset characters:starwars:4 "id" 4 "name" "Darth Vader" "pic" "https://vignette.wikia.nocookie.net/fr.starwars/images/3/32/Dark_Vador.jpg" "homeworld" "tatooine"
hset characters:starwars:5 "id" 5 "name" "Leia Organa" "pic" "https://vignette.wikia.nocookie.net/starwars/images/f/fc/Leia_Organa_TLJ.png" "homeworld" "alderaan"
hset characters:starwars:6 "id" 6 "name" "Owen Lars" "pic" "https://vignette.wikia.nocookie.net/starwars/images/e/eb/OwenCardTrader.png" "homeworld" "tatooine"
hset characters:starwars:7 "id" 7 "name" "Beru Whitesun lars" "pic" "https://vignette.wikia.nocookie.net/starwars/images/c/cc/BeruCardTrader.png" "homeworld" "tatooine"
hset characters:starwars:8 "id" 8 "name" "R5-D4" "pic" "https://vignette.wikia.nocookie.net/starwars/images/c/cb/R5-D4_Sideshow.png" "homeworld" "tatooine"
hset characters:starwars:9 "id" 9 "name" "Biggs Darklighter" "pic" "https://vignette.wikia.nocookie.net/starwars/images/0/00/BiggsHS-ANH.png" "homeworld" "tatooine"
hset characters:starwars:10 "id" 10 "name" "Obi-Wan Kenobi" "pic" "https://vignette.wikia.nocookie.net/starwars/images/4/4e/ObiWanHS-SWE.jpg" "homeworld" "stewjon"
hset characters:starwars:11 "id" 11 "name" "Anakin Skywalker" "pic" "https://vignette.wikia.nocookie.net/starwars/images/6/6f/Anakin_Skywalker_RotS.png" "homeworld" "tatooine"
hset characters:starwars:12 "id" 12 "name" "Wilhuff Tarkin" "pic" "https://vignette.wikia.nocookie.net/starwars/images/c/c1/Tarkininfobox.jpg" "homeworld" "eriadu"
hset characters:starwars:13 "id" 13 "name" "Chewbacca" "pic" "https://vignette.wikia.nocookie.net/starwars/images/4/48/Chewbacca_TLJ.png" "homeworld" "kashyyyk"
hset characters:starwars:14 "id" 14 "name" "Han Solo" "pic" "https://vignette.wikia.nocookie.net/starwars/images/e/e2/TFAHanSolo.png" "homeworld" "corellia"
hset characters:starwars:15 "id" 15 "name" "Greedo" "pic" "https://vignette.wikia.nocookie.net/starwars/images/c/c6/Greedo.jpg" "homeworld" "Rodia"
hset characters:starwars:16 "id" 16 "name" "Jabba Desilijic Tiure" "pic" "https://vignette.wikia.nocookie.net/starwars/images/7/7f/Jabba_SWSB.png" "homeworld" "tatooine"
hset characters:starwars:18 "id" 18 "name" "Wedge Antilles" "pic" "https://vignette.wikia.nocookie.net/starwars/images/6/60/WedgeHelmetless-ROTJHD.jpg" "homeworld" "corellia"
hset characters:starwars:19 "id" 19 "name" "Jek Tono Porkins" "pic" "https://vignette.wikia.nocookie.net/starwars/images/e/eb/JekPorkins-DB.png" "homeworld" "bestine"
hset characters:starwars:20 "id" 20 "name" "Yoda" "pic" "https://vignette.wikia.nocookie.net/starwars/images/d/d6/Yoda_SWSB.png"
hset characters:starwars:21 "id" 21 "name" "Palpatine" "pic" "https://vignette.wikia.nocookie.net/starwars/images/d/d8/Emperor_Sidious.png" "homeworld" "naboo"

zadd characters:starwars 0 1 0 2 0 3 0 4 0 5 0 6 0 7 0 8 0 9 0 10 0 11 0 12 0 13 0 14 0 15 0 16 0 18 0 19 0 20 0 21  


```
