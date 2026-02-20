# Exercice

Pour démarrer le front : docker compose up --build

accéder au front : aller sur http://localhost:4200

Le projet front_sobble lance un serveur qui va faire plusieurs requetes que vous devez implémenter dans le projet springboot g: 
1) à larrivée sur la page un appel GET http://localhost:9090/game
 Format de la répone : {id, name}
2) quand on clic sur une partie un appel GET http://localhost:9090/game/3/Cards
format de la réponse :
```json
{
"cards": [
  {
    "id": 0,
    "shapes": [
      {
        "id": 0,
        "color": "RED",
        "type": "RECTANGLE"
      }
    ]
  },
  {
    "id": 2,
    "shapes": [
      {
        "id": 2,
        "color": "BLUE",
        "type": "RECTANGLE"
      },
      {
        "id": 3,
        "color": "RED",
        "type": "CIRCLE"
      }
    ]
  }
```
3) quand on clic sur une partie un appel GET http://localhost:9090/game/3
Format de la réponse :
```json
{
  "id": 3,
  "name": "easy game 2 cards",
  "isOver": false,
  "score": -1,
  "gameDuration": 257,
  "cardsNumber": 2,
  "numberWonCard": 1,
  "referenceCard": {
    "id": 0,
    "shapes": [
    {
        "id": 0,
        "color": "RED",
        "type": "RECTANGLE"
    }
    ]
  },
  "hand": {
    "id": 1,
    "shapes": [
        {
        "id": 0,
        "color": "RED",
        "type": "RECTANGLE"
        }
    ]
  }
}
```