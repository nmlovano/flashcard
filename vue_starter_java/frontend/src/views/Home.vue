
<template>

  <div class="home">

    <h1>FlashCard Study Capstone</h1>
    
      <div class="flip-card">
        <div class="flip-card-inner">
      
          <div class="flip-card-front">
         <div class="flip-card-inner-back">
               <div class="flip-card-inner-front">
            <img src="../Images/Flashcards (1).png" alt="TE" style="width:300px;height:300px;">
           </div>
          <div class="flip-card-back">
            <h2>Flashcard Study App</h2>
            </div>
          <div class="  flip-card-inner-back-title"
        
   	</div>  
    	</div>       
          </div>
       </div>      
      </div>
</template>


<style>

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
.flip-card-inner {
  
  width: 300px;
  height: 300px;
  text-align: center;
  transition: transform 0.8s;
  transform-style: preserve-3d;
}
.flip-card-front, .flip-card-back {
  position:relative;
  width: 100%;
  height: 80%;
  
}
.flip-card:hover
.flip-card-inner{
  transform: rotateY(180deg);
  transform: rotateY(180deg);
   backface-visibility: hidden;
}

.flip-card,
.flip-card-inner-front,
.flip-card-inner-back {
  width: 100%;
  height: 20rem;
}

.flip-card-inner {
  transition: 0.6s;

}

.flip-card-inner-front,
.flip-card-inner-back {

  position: absolute;
  top: 0;
  left: 0;
}



.flip-card-inner-back {

  display: flex;
  text-align: center;
 background: url("../Images/card.jpg") 0 0 0 no-repeat;

}

.flip-card-inner-back-title {
  font-weight: bold;

            z-index: 2;
  display: flex;
  

}

.flip-card-inner-back-text {
  line-height: 1.3;
  
}

</style>