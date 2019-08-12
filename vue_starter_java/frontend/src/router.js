import Vue from 'vue'
import Router from 'vue-router'
import auth from './auth'
import Home from './views/Home.vue'
import Login from './views/Login.vue'
import Register from './views/Register.vue'
import Search from './views/Search.vue'
import User from './views/User.vue'
import SearchResults from './views/SearchResults.vue'
import Decks from './views/Decks.vue'
import Card from './views/Card.vue'
import Admin from './views/Admin.vue'
import Contact from './views/Contact.vue'
Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
<<<<<<< HEAD
        path: '/',
=======
        path: '/Home',
>>>>>>> e3b12233a2e04e50a0980ee45b6ce910037b1192
        name: 'home',
        component: Home,
        meta: {
          requiresAuth: true
        }
      },
      
    {
<<<<<<< HEAD
      path: "/login",
=======
      path: "/Login",
>>>>>>> e3b12233a2e04e50a0980ee45b6ce910037b1192
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
<<<<<<< HEAD
      path: "/register",
=======
      path: "/Register",
>>>>>>> e3b12233a2e04e50a0980ee45b6ce910037b1192
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
<<<<<<< HEAD
      path: "/search",
=======
      path: "/Search",
>>>>>>> e3b12233a2e04e50a0980ee45b6ce910037b1192
      name: "search",
      component: Search,
      meta: {
        requiresAuth: false
      }
      },
      {
<<<<<<< HEAD
        path: "/user",
=======
        path: "/User",
>>>>>>> e3b12233a2e04e50a0980ee45b6ce910037b1192
        name: "user",
        component: User,
        meta: {
          requiresAuth: false
        }
      },
    {
      path: "/SearchResults",
      name: "searchresults",
      component: SearchResults,
        meta: {
        requiresAuth: false
        }
    },
    {
<<<<<<< HEAD
      path: '/decks',
=======
      path: '/Decks',
>>>>>>> e3b12233a2e04e50a0980ee45b6ce910037b1192
      name: 'decks',
      component: Decks,
    
    },
    {
<<<<<<< HEAD
      path: '/card',
=======
      path: '/Card',
>>>>>>> e3b12233a2e04e50a0980ee45b6ce910037b1192
      name: 'card',
      component: Card,
    
    },
    {
<<<<<<< HEAD
      path: '/contact',
=======
      path: '/Login',
      name: 'accountcreated',
      component: Login,
    
    },
    {
      path: '/Contact',
>>>>>>> e3b12233a2e04e50a0980ee45b6ce910037b1192
      name: 'contact',
      component: Contact,
    
    },
    {
<<<<<<< HEAD
      path: '/admin',
=======
      path: '/Admin',
>>>>>>> e3b12233a2e04e50a0980ee45b6ce910037b1192
      name: 'admin',
      component: Admin,
      meta: {
        requiresAuth: true
      }
    },
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);
  const user = auth.getUser();

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && !user) {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
