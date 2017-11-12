# -*- coding: utf-8 -*-
"""
Created on Sat Nov 11 17:18:01 2017

@author: Brian
"""

import os
import fnmatch 
import shutil

images = ['*.txt']

def gen_move(filepat,top):
    for root, dirnames, filenames in os.walk(top):
        for extensions in images:
            for filename in fnmatch.filter(filenames, extensions):
                yield os.path.join(root, filename)

if __name__ == '__main__':
    src = 'C:/Users/Brian/Downloads'
    dst = 'C:/Users/Brian/Documents/hack'
    filesToMove = gen_move(images,src)
    for name in filesToMove:
        shutil.copy(name, dst)




