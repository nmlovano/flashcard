<template>
  <div class="home">
    <router-link to="/home"></router-link>
    <div class="flip-card card" ontouchstart="this.classList.toggle('hover');">
          <div class="flip-card-inner">
            <div class="flip-card-inner-front">
              <span>Flashcard Study</span>
            </div>
            <div class="flip-card-inner-back">
              <h3 class="flip-card-inner-back-title">Educate Yourself</h3>
              <p class="flip-card-inner-back-text">Intelligence looks good on you.</p>
            </div>
          </div>
    
        
    <div card="card">
      <div class="flip-card">
        <div class="flip-card-inner">
          <div class="flip-card-front">
            <img src="../Images/Flashcards (1).png" posistion="center" alt="TE" style="width:300px;height:300px;">
            </div>
          <div class="flip-card-back">
         
		</div>
		<!-- If not authenticated -->
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

.flip-card {
  -webkit-perspective: 1000;
          perspective: 1000;
  border: 0;
  background: transparent;
}

.flip-card:hover .flip-card-inner,
.flip-card.hover .flip-card-inner {
  -webkit-transform: rotateY(180deg);
          transform: rotateY(180deg);
}

.flip-card,
.flip-card-inner-front,
.flip-card-inner-back {
  width: 100%;
  height: 20rem;
}

.flip-card-inner {
  transition: 0.6s;
  -webkit-transform-style: preserve-3d;
          transform-style: preserve-3d;
  position: relative;
  -webkit-backface-visibility: hidden;
          backface-visibility: hidden;
}

.flip-card-inner-front,
.flip-card-inner-back {
  -webkit-backface-visibility: hidden;
          backface-visibility: hidden;
  position: absolute;
  top: 0;
  left: 0;
}

.flip-card-inner-front {
  background: white;
  z-index: 2;
  display: -webkit-flex;
  display: -ms-flexbox;
  display: flex;
  -webkit-align-items: center;
      -ms-flex-align: center;
          align-items: center;
  -webkit-justify-content: center;
      -ms-flex-pack: center;
          justify-content: center;
}

.flip-card-inner-front span {
  width: 100%;
  text-align: center;
  background: rgba(254, 254, 254, 0.8);
  padding: 0.25rem 0;
  font-size: 1.25rem;
  font-weight: bold;
}

.flip-card-inner-back {
  -webkit-transform: rotateY(180deg);
          transform: rotateY(180deg);
            z-index: 2;
  display: -webkit-flex;
  display: -ms-flexbox;
  display: flex;
  -webkit-align-items: center;
      -ms-flex-align: center;
          align-items: center;
  -webkit-justify-content: center;
      -ms-flex-pack: center;
          justify-content: center;
  -webkit-flex-direction: column;
      -ms-flex-direction: column;
          flex-direction: column;
  text-align: center;
 background: url("../Images/card.jpg") 0 0 0 no-repeat;

}

.flip-card-inner-back-title {
  font-weight: bold;

            z-index: 2;
  display: -webkit-flex;
  display: -ms-flexbox;
  display: flex;
  -webkit-align-items: center;
      -ms-flex-align: center;
          align-items: center;
  -webkit-justify-content: center;
      -ms-flex-pack: center;
          justify-content: center;
  -webkit-flex-direction: column;
      -ms-flex-direction: column;
          flex-direction: column;
  text-align: center;

}

.flip-card-inner-back-text {
  line-height: 1.3;
  
}

</style>