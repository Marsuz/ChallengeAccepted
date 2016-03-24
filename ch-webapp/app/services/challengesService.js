/**
 * Created by Sara on 2016-03-19.
 */

app.factory('Challenges', function(){
    var database = {newchallenges: [
        {
            id: 1,
            name: "Wez Grabcia na silke",
            owner: 'Zajda',
            expirationdate: '2016-03-22',
            image: 'small_cup.png',
            participants: [
                {
                    id: 1,
                    name: 'Shimmy'
                }
            ],
            invited: [
                {
                    id: 1,
                    name: 'Zajda'
                }
            ]
        },
        {
            id: 2,
            name:"Wypij jak najwiecej energoli",
            owner: 'Shimmy',
            expirationdate: '2016-03-22',
            image: 'small_podium.jpg',
            participants: [
                {
                    id: 1,
                    name: 'Marcin'
                }
            ],
            invited: [
                {
                    id: 1,
                    name: 'Zajda'
                }
            ]
        }
    ],
    acceptedchallenges: [
        {
            id: 1,
            name: "BrainCode",
            owner: 'Zajda',
            expirationdate: '2016-03-22T14:48:00',
            image: 'small_podium.jpg',
            participants: [
                {
                    id: 1,
                    name: 'Shimmy'
                }
            ],
            invited: [
                {
                    id: 1,
                    name: 'Zajda'
                }
            ]
        },
        {
            id: 2,
            name:"ULTRICIES SED MAGNA EUISMOD ENIM VITAE GRAVIDA",
            owner: 'Shimmy',
            expirationdate: '2016-03-22T15:48:00',
            image: 'small_cup.png',
            participants: [
                {
                    id: 1,
                    name: 'Marcin'
                }
            ],
            invited: [
                {
                    id: 1,
                    name: 'Zajda'
                }
            ]
        }
    ],
        rejectedchallenges: [
            {
                id: 1,
                name: "3 warunki w tym semestrze",
                owner: 'Zajda',
                expirationdate: '2016-03-21T12:48:00',
                image: 'small_podium.jpg',
                participants: [
                    {
                        id: 1,
                        name: 'Shimmy'
                    }
                ],
                invited: [
                    {
                        id: 1,
                        name: 'Zajda'
                    }
                ]
            },
            {
                id: 2,
                name:"NIE WYŁĄCZAJ KOMPA PRZEZ X DNI",
                owner: 'Shimmy',
                expirationdate: '2016-04-26T09:48:00',
                image: 'small_cup.png',
                participants: [
                    {
                        id: 1,
                        name: 'Marcin'
                    }
                ],
                invited: [
                    {
                        id: 1,
                        name: 'Zajda'
                    }
                ]
            }
        ],
        finishedchallenges: [
            {
                id: 1,
                name: "Aghacks",
                owner: 'Zajda',
                expirationdate: '2016-02-22T15:48:00',
                image: 'small_podium.jpg',
                participants: [
                    {
                        id: 1,
                        name: 'Shimmy'
                    }
                ],
                invited: [
                    {
                        id: 1,
                        name: 'Zajda'
                    }
                ]
            },
            {
                id: 2,
                name:"costam",
                owner: 'Shimmy',
                expirationdate: '2016-02-22T14:48:00',
                image: 'small_cup.png',
                participants: [
                    {
                        id: 1,
                        name: 'Marcin'
                    }
                ],
                invited: [
                    {
                        id: 1,
                        name: 'Zajda'
                    }
                ]
            }
        ]
        
    };


    return {
        db: database,
        add: function (challenge) {
            database.newchallenges.push(challenge);
        }
    };
})
