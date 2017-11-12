import os
import fnmatch
import shutil
import gzip
counter = 0
images = ['*.txt']
newpath = r'/Users/James/Documents/hack'
if not os.path.exists(newpath):
    os.makedirs(newpath)

def gen_move(filepat,top):
    for root, dirnames, filenames in os.walk(top):
        for extensions in filepat:
            for filename in fnmatch.filter(filenames, extensions):
                yield os.path.join(root, filename)

if __name__ == '__main__':
    src = '/Users/James/Downloads'
    dst = '/Users/James/Documents/hack'
    filesToMove = gen_move(images,src)
    for name in filesToMove:
        shutil.copy(name, dst)
        counter +=1
        print name
print counter
