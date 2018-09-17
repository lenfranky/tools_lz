from pymongo import MongoClient
import googlemaps
import time

kwargs = {
    'proxies': {'https': 'http://127.0.0.1:7078'}
}
api_keys = [
    # 'AIzaSyA03iYDDuYcZkUFkcJs1pCJhDlzkg7-TCE',
    # 'AIzaSyDlvoft8cTU8ZdA-nQ8pwLX8o0NPdZTnvo',
    # 'AIzaSyDPA0ZTG8nVu6vbbcx6eECUjra3O-S4YKQ',
    # 'AIzaSyALDmiiiJWgnd0PGXAADYL2Bg4aSreRldY',
    # 'AIzaSyDdgjD5SC7BiwHZi7pEudN_LBrZOkM65c4',
    # 'AIzaSyCyI6YJWJp9qnag3qy_CW4q9Qg8GUX5Z3E',
    'AIzaSyBKC5WsYvMdEDGXaQRBQy6JF5zYoikDX3g',
    'AIzaSyBgwM6GliD1K4Z2y-QCweLdO459eDM1Mto',
    'AIzaSyDBJcfMH6B20ersPnEhBjqp-ScOjLV7uV0',
    'AIzaSyCSL1OV7hT87mCmjci2Qus4QytmpHfkzQs',
    'AIzaSyBYvODyIvoAhe_efjbTb93V4UuSSE6vczU',
    'AIzaSyA4IHWsLs_u-vg2EakvDT42BGD2V3gNlYE',
    'AIzaSyBC8BiwVXx0mHDSQzgm3nbHY_t_mQ0so8I',
    'AIzaSyBZE1UHM6Nlnzzn9efy2p7tZnq28scC6nk',
    'AIzaSyDR2tyl1p946HOyaheEV3iGKJPHTW9ulDc',
    'AIzaSyB_DEfF6pubepEJUgi8-r_cJ3lop6JnLlc',
    'AIzaSyAjYZXbFIVvOP13PKB1DGtcHoTP5OUxg30',
    'AIzaSyCqSr3msKukBmwwvJb6gKPWhyw-Imfk4nM',
    'AIzaSyBh2q4JpQSHRLv-zWgPNqOhuoowQdeePqU',
    'AIzaSyCxeF5-ywhHl-tGVjJCsBQ8hAlAjMGOAL8',
    'AIzaSyBrciwtGxzniUjhisHk2EctXUcufhNt7cM',
    'AIzaSyBAug7lHv8tlkdFL-Iu60NcCW3tB3CuZR4',
    'AIzaSyCTxPb1ac-0803PruPxe8woVdxl_uQaPjs',
    'AIzaSyCWeU47lMnLmQtpltt7gsZStBZS4ntsPso',
    'AIzaSyDH1xiWdHDbALe9WHlzOOSv4PKwQL-hutk',
    'AIzaSyBftSwYJWIHYu7M9dXzqLKLQMo_Ov-EM4w',
    'AIzaSyDgg5H2yJXWicB2Snk6nyqncj4CUojhmEM',
    'AIzaSyA1WzIqpHdeHedUT_GsqE7Ioj-TiUOxiZc'
]
api_keys_2 = []
# gmaps = googlemaps.Client(key='AIzaSyBC8BiwVXx0mHDSQzgm3nbHY_t_mQ0so8I', requests_kwargs=kwargs)
# gmaps = googlemaps.Client(key='AIzaSyBZE1UHM6Nlnzzn9efy2p7tZnq28scC6nk', requests_kwargs=kwargs)
# gmaps = googlemaps.Client(key='AIzaSyA03iYDDuYcZkUFkcJs1pCJhDlzkg7-TCE', requests_kwargs=kwargs)
# gmaps = googlemaps.Client(key='AIzaSyDlvoft8cTU8ZdA-nQ8pwLX8o0NPdZTnvo', requests_kwargs=kwargs)
# gmaps = googlemaps.Client(key='AIzaSyDPA0ZTG8nVu6vbbcx6eECUjra3O-S4YKQ', requests_kwargs=kwargs)
# gmaps = googlemaps.Client(key='AIzaSyALDmiiiJWgnd0PGXAADYL2Bg4aSreRldY', requests_kwargs=kwargs)
# gmaps = googlemaps.Client(key='AIzaSyDdgjD5SC7BiwHZi7pEudN_LBrZOkM65c4', requests_kwargs=kwargs)
count = 1
location_count = 0
i = 0
gmaps = googlemaps.Client(key=api_keys[i], requests_kwargs=kwargs)
geocode_result = gmaps.geocode('TUSNET Tokyo University of Science')
print geocode_result
if geocode_result:
    print geocode_result[0].keys()
    print geocode_result[0]['formatted_address']
    print "######"
    for item in geocode_result[0]['address_components']:
        print item['long_name']
        print item['short_name']