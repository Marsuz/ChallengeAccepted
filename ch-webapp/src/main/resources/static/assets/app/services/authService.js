/**
 * Created by Marcin on 19.03.2016.
 */

app.factory('AuthService',function ($resource) {
    return $resource('/users',{},{
        logIn: {
            method: 'POST',
            url: '/users/login',
            params: {username: '@username', password: '@password'}
        },
        
        signUp: {
            method: 'POST',
            url: '/users/register',
            params: {username: '@username', name: '@firstName', surname: '@lastName', password: '@password'}
        }
    })
})