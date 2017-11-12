import os
import fnmatch
import shutil
import gzip

images = ['*.ppt']
newpath = r'C:/Users/Brian/Documents/hack'
if not os.path.exists(newpath):
    os.makedirs(newpath)

def gen_move(filepat,top):
    for root, dirnames, filenames in os.walk(top):
        for extensions in filepat:
            for filename in fnmatch.filter(filenames, extensions):
                yield os.path.join(root, filename)

if __name__ == '__main__':
    src = 'C:/Users/Brian/Downloads'
    dst = 'C:/Users/Brian/Documents/hack'
    filesToMove = gen_move(images,src)
    for name in filesToMove:
        shutil.copy(name, dst)




