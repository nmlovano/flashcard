<template>
  <div class="home">
    <h1>Home</h1>
      <div class="flip-card">
        <div class="flip-card-inner">
          <div class="flip-card-front">
            <img src="/Images/Flashcards (1).png" alt="TE" style="width:300px;height:300px;">
          </div>
          <div class="flip-card-back">
            <h1>FlashCard Study Capstone</h1> 
            <p>Cohort 11</p> 
           
          </div>
        </div>
      </div>
      </div>
</template> 

<script>
export default {
  name: 'home'
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
  margin-left: auto;
  margin-right: auto;
font-family: serif;
font-size: 12px;

  background-color: transparent;
  width: 300px;
  height: 200px;
  border: 1px solid #f1f1f1;

}
.flip-card-inner {
  position: relative;
  width: 300px;
  height: 200px;
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
