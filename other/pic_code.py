# -*- coding: utf-8 -*-

import codecs
from PIL import Image, ImageDraw
import numpy as np

size = 450

def encode_pic_old(text_file_path_1, text_file_path_2, text_file_path_3, pic_file_path = 'test.png'):
    image = Image.new('RGB', (size, size), (255,255,255))
    draw = ImageDraw.Draw(image)
    count_img_point = 0

    file_read_1 = codecs.open(text_file_path_1, encoding='utf-8', mode = 'rb')
    file_read_2 = codecs.open(text_file_path_1, encoding='utf-8', mode='rb')
    file_read_3 = codecs.open(text_file_path_1, encoding='utf-8', mode='rb')

    while True:
        temp = file_read_1.read(1)
        if len(temp) == 0:
            break
        else:
            # print temp
            current_code = temp.encode('raw_unicode_escape').encode('hex')
            # print current_code
            # total_text += current_code
            for char in current_code:
                if 48 <= ord(char) <= 57:
                    current_num = ord(char) - 48
                elif 97 <= ord(char) <= 102:
                    current_num = ord(char) - 97 + 10
                else:
                    current_num = 0
                # print current_num,
                row = count_img_point / (size-1)
                col = count_img_point % (size-1)
                print "row:%d, \tcol:%d, color:\t" % (row, col) + str((current_num, 0, 0))
                draw.point((row, col), fill=(current_num, 0, 0))
                count_img_point += 1

    # print total_text.decode('hex').decode('raw_unicode_escape')

    img = np.array(image)
    text_encode = ""
    for row in range(size):
        for col in range(size):
            color = img[row][col]
            print "row:%d, \tcol:%d, color:\t" % (row, col) + str(color)

    image.save(pic_file_path)
    print "all_count_img_point:\t" + str(count_img_point)


def encode_pic(text_file_path_1=None, text_file_path_2=None, text_file_path_3=None, pic_file_path = 'test.png'):
    image = Image.new('RGB', (size, size), (255,255,255))
    count_img_point = 0

    file_read_3 = codecs.open(text_file_path_1, encoding='utf-8', mode='rb')

    image_array = np.array(image)

    if text_file_path_1:
        file_read_1 = codecs.open(text_file_path_1, encoding='utf-8', mode='rb')
        single_encode(file_read_1, image_array, 0)

    if text_file_path_2:
        file_read_2 = codecs.open(text_file_path_2, encoding='utf-8', mode='rb')
        single_encode(file_read_2, image_array, 1)

    if text_file_path_3:
        file_read_3 = codecs.open(text_file_path_3, encoding='utf-8', mode='rb')
        single_encode(file_read_3, image_array, 2)

    image = Image.fromarray(image_array)

    image.save(pic_file_path)


def single_encode(file_read, image_array, num=0):
    count_img_point = 0
    while True:
        temp = file_read.read(1)
        if len(temp) == 0:
            break
        else:
            current_code = temp.encode('raw_unicode_escape').encode('hex')
            for char in current_code:
                if 48 <= ord(char) <= 57:
                    current_num = ord(char) - 48
                elif 97 <= ord(char) <= 102:
                    current_num = ord(char) - 97 + 10
                else:
                    current_num = 0
                row = count_img_point / size
                col = count_img_point % size
                # print "row:%d, \tcol:%d, color:\t" % (row, col) + str((current_num, 0, 0))
                image_array[row][col][num] = current_num
                count_img_point += 1
    print "all_count_img_point_file_1:\t" + str(count_img_point)


def decode_pic(pic_file_path):
    # size = 100
    image = Image.open(pic_file_path)
    img = np.array(image)
    single_decode(img, 0)
    single_decode(img, 1)
    single_decode(img, 2)


def single_decode(img, num):
    text_encode = ""
    color = (255, 255, 255)
    for row in range(size):
        for col in range(size):
            color = img[row][col]
            current_code = color[num]
            # print "row:%d, \tcol:%d, color:\t"%(row, col) + str(color)
            if 0 <= current_code <= 9:
                text_encode += str(current_code)
            elif 10 <= current_code <= 15:
                text_encode += str(chr(current_code + 97 - 10))
            elif current_code == 255:
                break
            else:
                print "error"
        if color[num] == 255:
            break

    print text_encode
    text_result = text_encode.decode('hex').decode('raw_unicode_escape')

    with codecs.open('result_%d.py' % num, mode='wb', encoding='utf-8') as file_write:
        file_write.write(text_result)


if __name__ == '__main__':
    text_file_path_1 = '../tools/google_cn.py'
    text_file_path_2 = '../codes/linkedin_operation.py'
    text_file_path_3 = '../codes/mailbox_operation.py'
    pic_file_path = '../fig/test.png'
    encode_pic(text_file_path_1, text_file_path_2, text_file_path_3, pic_file_path = pic_file_path)
    decode_pic(pic_file_path)
    pass
