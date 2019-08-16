<template>
  <div>
    <h1>Here's your cards</h1>
    <ul id="cardsByDeckShuffled">
      <li v-for="item in card" v-bind:key="item.id">
        <div class="flip-card">
          <div class="flip-card-inner">
            <div class="flip-card-front">
              <div id="card-front">{{item.frontText}}</div>
            </div>
            <div class="flip-card-back">
              <div id="card-back">{{item.backText}}</div>
            </div>  
          </div>
        </div>
        <div id="card-tags">Tags: " {{item.cardTag}} "</div>
      </li>
    </ul>
  </div>
</template>

<script>
import auth from '../auth';

export default {
    data() {
        return { 
            API_URL: process.env.VUE_APP_REMOTE_API,
            card: null
        }
    },
    methods: {
        getCardByDeckShuffled(){
            const deckId = this.$route.params.deckId;
            fetch(this.API_URL + '/shuffled/' + deckId, {
                headers: {
                    Authorization: 'Bearer ' + auth.getToken()
                }
            })
            .then((response) => {
                console.log(response);
                return response.json();
            })
            .then((card) => {
                console.log (card);
                this.card = card;
            }); 
        }
    },
    created() {
        this.getCardByDeckShuffled();
    }
    
}
</script>

<style>
#cardsByDeckShuffled{
    list-style: none;
}
.flip-card {
  margin-top: 100px;
  margin-left: auto;
  margin-right: auto;
  background-color: transparent;
  width: 400px;
  height: 200px;
  perspective: 1000px;
  padding: 20px;
}
.flip-card-inner {
  position: relative;
  width: 100%;
  height: 100%;
  text-align: center;
  transition: transform 0.6s;
  transform-style: preserve-3d;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
}
.flip-card:hover .flip-card-inner {
  transform: rotateY(180deg);
}
.flip-card-front, .flip-card-back {
  position: relative;
  font-weight: bold;
  font-size: 30px;
  width: 100%;
  height: 100%;
  backface-visibility: hidden;
  vertical-align: middle;
}

.flip-card-front {
  background-color:white;
  color: black;
}
.flip-card-back {
  background-color:green;
  color: white;
  transform: rotateY(180deg);
}
#card-tags{
    font-size: 20px;
    font-weight:bold;
    font-style: italic;
    text-align: center;
}

</style>