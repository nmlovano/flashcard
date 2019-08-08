export default {

    list() {
      return fetch('https://jsonplaceholder.typicode.com/decks')
      .then((response) => {
        return response.json();
      });
    },
  
    get(deckId) {
      return fetch(`https://jsonplaceholder.typicode.com/decks/${deckId}`)
      .then((response) => {
        return response.json();
      });
    }
  
  }
  