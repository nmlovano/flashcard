<script>
import auth from "../auth"
export default {
methods:{
     logout(){
      auth.logout(); 
      this.$router.push('/home');
    }
},
created() {
this.logout();
}

}

</script>