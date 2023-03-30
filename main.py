# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.

def classical(mat_1, mat_2):
    rows = mat_1.length()
    col = mat_2[0].length()
    mat_f = [[0]*rows]*col
    for i in (range (0,(mat_1.range()-1))):
        for j in (range (0, mat_2.range()-1)):
            mat_f[i][j] = 0
            for k in (range (0, (mat_f.range()-1))):
                mat_f[i][j] += mat_1[i][k] * mat_2[k][j]
    print(mat_f)
def div_n_conq(mat_1, mat_2):
    if mat_1.length > 4:


# See PyCharm help at https://www.jetbrains.com/help/pycharm/
