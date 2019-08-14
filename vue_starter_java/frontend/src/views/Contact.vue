<template>
  <div class="contact">
    <h1 class="pageIdentifier">{{currentPage}}</h1>
    <div class="form">
      <form class="contactForm" action="submit">
       
        <label for="cname">Full Name</label>
      <input type="text"
          placeholder="Your name"
          autocomplete="nada"
          name="cname"
          v-model="fullName"/>

        <label for="email">Email</label>
        <input type="text"
          autocomplete="nada"
          name="email" 
          placeholder="you@email.com"
        v-model="email"
      />
      <label for="email">Message</label>
      <input type="text"
       placeholder="We'd love to hear what you have to say!"
      
        v-model="message" />

    
        <button class="subButt"
          type="submit"
          @click.prevent="()=>{submitMessage()}"
          
        >Send It!</button>
      </form>
    </div>
  </div>
  </div>
</template>

<script>

  export default{
    name: "Contact",
    data(){
      return{
        fullName:"",
        email:"",
        subject:"",
        message:"",
      }
    },
    methods:{
      deckAddedNotification(){
          this.$snotify.success(
              "Message Sent!",
              'Contact Message',{
                  timeout: 2000,
                  pauseOnHover: true
              }
          );
      },
      submitMessage(){
        const newMess = {
          fullName:this.fullName,
          email:this.email,
          subject: this.subject,
          message: this.message,
        }
        Api.pushMessage(newMess)
            .then(()=>{
              console.log("New Message in Database");
            });
        this.deckAddedNotification();
        this.fullName="";
        this.email="";
        this.subject="";
        this.message="";
      }
    },
    computed:{
      // isComplete(){
      //   return this.cname && this.email && this.subject && this.message;
      // }
    }
  }
</script>

<style>
.contact{
      background-color: #FF5D73;
}
 .contactForm{
             
font-weight:500;
        text-align:center;
        font-size: 16px;
            border-radius: 10px;
    position: fixed;
    top:50%;
    bottom: 50%;
   justify-content: center;
      }
      .label{
          font-weight: 600;
         
          
        }
      
        .subButt{
          font-size: 20px;
          font-family: Avenir;
          color: #FF5D73;
          border-radius: 5px;
          background: transparent;
          font-weight: 600;
          border: 2px solid;
 border-color: #333;
  text-align: center;
  font-size: 16px;
  margin: 4px 2px;

}
        
         .button :hover{
            cursor: pointer;
         
          }
        
        .label{
          font-weight: 600;
          color: white;
          opacity: .6;
        }
        .input[type=text]{
          border-radius: 5px;
          color:#565554;
      
          font-family: Avenir;
          font-size: 20px;
          font-weight: 700;
          width: 50%;
          height:50%;
          border: #333 10px solid;
       
        }
        .input[type=text]:focus {
    border-color:#333;
}
    .input[type=text]::placeholder{
        color: white;
            opacity: .6;
          
    }
        input[type=email]{
          border-radius: 5px;
          color: white;
          padding: 15px;
          font-family: Avenir;
          font-size: 20px;
          font-weight: 700;
          width: 50%;
          outline-style: solid;
       outline-color: palevioletred;
       outline-width: medium;
          background: rgba(255,255,255,.2);
        }
           input[type=email]::placeholder{
               opacity: inherit;
           }
          .valid{
            background: rgba(144, 238, 144, 0.596);
          }
          .invalid{
            background: rgba(255, 0, 0, 0.486);
          }
        
        .messageinput{
          color: white;
          margin-top: 10px;
          width: 100%;
          font-family: Avenir;
          font-size: 20px;
          font-weight: 700;
          border-radius: 5px;
          border: 2px solid;
          background: rgba(255,255,255,.2);
        }
#contactMessage{
color:palevioletred;
border: 2px solid;
font-weight: 700;
          border-radius: 5px;
}
      
      .pageIdentifier{
        position: fixed;
        top: 180px;
        right: -50px;
        font-size: 75px;
        opacity: .5;
        color: white;
        transform: rotate(-90deg);
    }
</style>
