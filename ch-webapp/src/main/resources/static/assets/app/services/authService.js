/**
 * Created by Marcin on 19.03.2016.
 */

app.factory('AuthService',function ($resource) {
    return $resource('/users',{},{
        logIn: {
            method: 'POST',
            url: '/users/login',
            params: {username : '@username', password: '@password'}
        }
    })
})