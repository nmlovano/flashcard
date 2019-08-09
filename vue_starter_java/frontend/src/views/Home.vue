<template>
  <div class="home">
    <router-link to="/home"></router-link>
    <h1>FlashCard Study Capstone</h1>
      <div class="flip-card">
        <div class="flip-card-inner">
          <div class="flip-card-front">
            <img src="../Images/Flashcards (1).png" alt="TE" style="width:300px;height:300px;">
            </div>
          <div class="flip-card-back">
            <h1>FlashCard Study Capstone</h1> 
            <p>Cohort 11</p> 
            <div class="row mb-2" v-if="authenticated">
			<div class="col"></div>
			<div class="col">
				<h2>My Decks</h2>
			</div>
			<div class="col">
				<input type="text" class="form-control input-group-sm" placeholder="Filter by tags" v-model="filterValue">
			</div>
			<div class="col-12">
				<my-deck-list :decks="privateDecks" :filter="filterValue"></my-deck-list>
				<hr>
			</div>
		</div>
		<!-- If not authenticated -->
		<div class="row mb-4" v-else>
			<div class="col-12">Login to create private decks and track your scores</div>
			<div class="col-12"><auth-buttons></auth-buttons></div>
		</div>
		<div class="row mt-2">
			<div class="col-12">
				<public-deck-list :decks="publicDecks" :filter="filterValue"></public-deck-list>
			</div>
		</div>
	</div>
          </div>
        </div>
      </div>
</template>
<script>
export default {
  name: 'home',
  views: {

  },
  data() {
		return {
			filterValue: ''
		}
	}
}
</script>

<style>
body{
   background-color: antiquewhite;
    
}
.home{
  color:black;
  font-family: Sans-serif;
  text-align: center;

}

.flip-card {
    display: block;
 
  margin-right: auto;
font-family: serif;
font-size: 12px;

  background-color: transparent;
  width: 300px;
  height: 200px;
  border: 1px solid #f1f1f1;

}
.student {
  display: block;
  margin-left: auto;
}
.flip-card-inner {
  position: relative;
  width: 300px;
  height: 300px;
  text-align: center;
  transition: transform 0.8s;
  transform-style: preserve-3d;
}
.flip-card:hover .flip-card-inner {
  transform: rotateY(180deg);
}
.flip-card-front, .flip-card-back {
  position: absolute;
  width: 100%;
  height: 100%;
  backface-visibility: hidden;
}
.flip-card-front {
  background-color: #bbb;
  color: black;
}
.flip-card-back {
  background-color: white;
  font-size: 14px;
  color: black;
  transform: rotateY(180deg);
}



</style>
