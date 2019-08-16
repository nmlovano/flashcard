
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  padding-top: 50 px;
}
#home{
 display: block;
  margin-left: auto;
  margin-right: auto;
  padding: 70px 0;
  width: 50%;
}
.flip-card {
  margin-top: 100px; 
  margin-left: auto;
  margin-right: auto;
  background-color: transparent;
  width: 300px;
  height: 300px;
  perspective: 1000px;
}
.flip-card-inner {
  position: relative;
  width: 100%;
  height: 100%;
  text-align: center;
  transition: transform 0.6s;
  transform-style: preserve-3d;
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
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
  background-color: #FF5D73;
  color: white;
  transform: rotateY(180deg);
  font-size: 20px;
}
   
</style>

<template>
<body>

<div id="home">
  
<div class="flip-card">
  <div class="flip-card-inner">
    <div class="flip-card-front">
      <img src="../Images/Flashcards (1).png" alt="TE" style="width:300px;height:300px;">
    </div>
    <div class="flip-card-back">
      <h1>Flashcard Capstone</h1> 
      <p>Lori - Sarah</p> 
      <p>Nathan - Chris</p>
      </div>
    </div>
  </div>
</div>

</body>
</template>
