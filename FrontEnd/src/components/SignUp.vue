<template>
    <div class="sign-up">
        <p>Sign Up</p>
        <input type="text" v-model="email" placeholder="email"><br>
        <input type="password" v-model="password" placeholder="password"><br>        
        <button v-on:click="signUp">가입하기</button>
        <span><router-link to='login'>로그인으로 돌아가기</router-link></span>
    </div>
</template>

<script>
    import firebase from 'firebase'

    export default {
        name : 'signUp',
        data : function(){
            return {
                email : '',
                password :'',
            }
        },
        methods:{
            signUp : function(){
                firebase.auth().createUserWithEmailAndPassword(this.email, this.password).then(
                    function(user){
                        console.log(user)
                        alert("성공적으로 회원가입")
                    },
                    function(err){
                        alert("회원가입 실패" +err.message)
                    }

                );
            }

        }
    }
</script>

<style scoped>
    .signUp{
        margin-top : 40px;
    }
    input{
        margin : 10px 0;
        width :20%;
        padding : 15px;
    }
    button{
        margin-top: 20px;
        width : 10%;
        cursor: pointer;
    }
    p{
        margin-top: 40px;
        font-size: 20px;
    }
    span{
        display: block;
        margin-top: 20px;
        font-size:15px;
    }
</style>