/**
 * Created by Marcin on 02.04.2016.
 */

app.factory('UserService', function ($resource) {
    return $resource{'/users',{},{
        getAllUsers: {
            method: 'GET',
            url: '/users/all'
        },

        getOneUser: {
            method: 'GET',
            //TODO url: '/users/@nickname',
            params: {nick: '@nickname'}
        },

        createUser: {
            method: 'POST',
            url: '/users/create'
            //TODO params
        },

        updateUser: {
            method: 'POST',
            url: 'users/update'
            //TODO params
        },

        deleteUser: {
            method: 'DELETE'
            //TODO params
        }


    }}

})