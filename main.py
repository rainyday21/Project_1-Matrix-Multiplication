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

def div_n_conq(mat_1, mat_2, amt):
    if (mat_1)
    
    if (len(mat_1) > 4 or len(mat_2) > 4):
        for i in range(0, 3):
            div_n_conq()