# -*- coding: utf-8 -*-
"""
Created on Sat Nov 11 17:18:01 2017

@author: Brian
"""

import os, fnmatch, shutil


images = ['*.txt']
mypath = 'C:/Users/Brian/Documents/hack'
whatever = 'C:/Users/Brian/Documents/hack2'
def makemydir(mypath):
  try:
    os.makedirs(mypath)
  except OSError:
    pass
  # let exception propagate if we just can't
  # cd into the specified directory
  os.chdir(whatever)
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

#import gzip
#import shutil
#with open('file.txt', 'rb') as f_in, gzip.open('file.txt.gz', 'wb') as f_out:
#    shutil.copyfileobj(f_in, f_out)

