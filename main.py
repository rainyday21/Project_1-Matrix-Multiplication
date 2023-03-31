def classical(mat_1, mat_2):
    rows = len(mat_1)
    col = len(mat_2[0])
    mat_f = [[0]*rows]*col
    for i in (range (len(mat_1))):
        for j in (range (len(mat_2[0]))):
            mat_f[i][j] = 0
            for k in (range(len(mat_f))):
                mat_f[i][j] += mat_1[i][k] * mat_2[k][j]
    print(mat_f)

# def div_n_conq(mat_1, mat_2, amt):
    if (len(mat_1) != )

def d_n_c_verify(mat):
    if (len(mat) != len(mat[0])):
        

mat1 = [[1,2,3],[4,5,6]]
##mat2 = [[1,2,3],[4,5,6]]
classical(mat1, mat1)