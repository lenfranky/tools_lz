# -*- coding:utf-8 -*-

from pymongo import MongoClient
import googlemaps
import time
import codecs
import xlrd
from xlutils.copy import copy

def loc_inquiry(loc):
    """
    得到输入地名的具体位置
    :param loc: 所要查询的位置
    :return: 该位置的维度、经度
    """
    kwargs = {
        'proxies': {'https': 'http://127.0.0.1:7078'}
    }
    api_keys = [
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
    count = 8
    location_count = 0
    i = 0
    gmaps = googlemaps.Client(key=api_keys[i], requests_kwargs=kwargs)
    geocode_result = gmaps.geocode(loc)
    if geocode_result:
        location = geocode_result[0].get('geometry').get('location')
        latitude = location.get('lat')
        longitude = location.get('lng')
        return latitude, longitude, geocode_result[0]['formatted_address']
    else:
        # print "未查询到该地名！"
        return None

def inquire_all_location(file_name = r'C:\Users\LenFranky\OneDrive\codes\learning\data\JapanAs.txt'):
    file_read = codecs.open(file_name, mode='r')
    count = 0
    for line in file_read:
        line = line.replace('\r', ' ').replace('\n', ' ')
        print line
        result = loc_inquiry(line)
        if result:
            print result
            count += 1

    print count


def inquire_all_location_save_file(file_name=r'C:\Users\LenFranky\OneDrive\codes\learning\data\JapanAs_locInfo.xls', start_row=1):
    excel_read = xlrd.open_workbook(file_name)
    sheet_read = excel_read.sheet_by_name('japanAs')
    excel_write = copy(excel_read)
    sheet_write = excel_write.get_sheet('japanAs')

    sheet_write.write(0, 5, 'longitude')
    sheet_write.write(0, 6, 'latitude')
    sheet_write.write(0, 7, 'formatted_address')

    row = sheet_read.nrows

    for n in range(start_row, row):
        content_row_true = sheet_read.row_values(n)
        company_name = content_row_true[2]
        company_name = company_name.replace('\r', ' ').replace('\n', ' ')
        if company_name == ',':
            continue
        try:
            result = loc_inquiry(company_name)
        except:
            print "第%d行出现问题" %n
        if result:
            print result

            latitude = result[0]
            longitude = result[1]
            formatted_address = result[2]

            sheet_write.write(n, 5, longitude)
            sheet_write.write(n, 6, latitude)
            sheet_write.write(n, 7, formatted_address)

            # 每检测50条储存一次
            if n % 50 == 0:
                excel_write.save(file_name)
                print "已完成" + str(n)

    excel_write.save(file_name)

    # 不需要关闭操作
    # excel_read.close()
    # excel_write.close()

def delete_not_part_of_Japan(file_name=r'C:\Users\LenFranky\OneDrive\codes\learning\data\JapanAs_locInfo.xls'):
    excel_read = xlrd.open_workbook(file_name)
    sheet_read = excel_read.sheet_by_name('japanAs')
    excel_write = copy(excel_read)
    sheet_write = excel_write.get_sheet('japanAs')

    row = sheet_read.nrows

    count_not_part_of_Japan = 0

    for n in range(1, row):
        line = sheet_read.row_values(n)
        formatted_address = line[7]
        formatted_address = formatted_address.replace('\r', ' ').replace('\n', ' ')
        if not formatted_address:
            continue
        word_loc = formatted_address.split(', ')
        if 'Japan' not in word_loc:
            print line[2]
            print formatted_address
            count_not_part_of_Japan += 1

            sheet_write.write(n, 5, '')
            sheet_write.write(n, 6, '')
            sheet_write.write(n, 7, '')

    print count_not_part_of_Japan

    excel_write.save(file_name)



if __name__ == '__main__':
    # loc = 'TUSNET Tokyo University of Science'
    loc = 'TOKYO6TO4 WIDE Project, JP'
    # inquire_all_location_save_file(file_name=r'C:\Users\LenFranky\OneDrive\codes\learning\data\JapanAs_locInfo.xls', start_row=650)
    delete_not_part_of_Japan()

