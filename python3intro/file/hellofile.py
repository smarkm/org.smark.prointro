import os
"""This file is for python 'file' func test,contains file create,open,read,write,and close etc."""
tmpdir = './tmp'
filename = './tmp/test.txt'
#1.create dir
if os.path.exists(tmpdir)==False:
    os.mkdir(tmpdir)
    print("dir not exsits and create it:"+tmpdir)
else:
    print("exists dir:"+tmpdir)
#2.create file and write data
f = open(filename,mode='w',encoding='utf-8')
f.write("hello from python")
f.close()


print("open and close the file :"+filename)
#3.remove file
#os.remove(filename)
print("remove the file:"+filename)

#4.remove dir
#os.removedirs(tmpdir)
print("remove dir:"+tmpdir)
