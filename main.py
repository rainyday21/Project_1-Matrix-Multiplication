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
