import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import firebase from 'firebase'

Vue.config.productionTip = false

var firebaseConfig={
  apiKey: "AIzaSyAyrYFHfzFr2Ete47jG98Nkal4qt2H8fJI",
  authDomain: "vue-firebase-cedb6.firebaseapp.com",
  databaseURL: "https://vue-firebase-cedb6.firebaseio.com",
  projectId: "vue-firebase-cedb6",
  storageBucket: "vue-firebase-cedb6.appspot.com",
  messagingSenderId: "562622467801",
  appId: "1:562622467801:web:ea3b81af2ac9b00df0f8c8",
  measurementId: "G-X7KSKFZ7JQ"
};

firebase.initializeApp(firebaseConfig);


new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
