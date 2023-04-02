def classical(mat_1, mat_2):
    rows = len(mat_1)
    col = len(mat_2[0])
    mat_f = []
    for i in (range(rows)):
        row = []
        for j in (range(col)):
            sum = 0
            for k in (range(len(mat_2))):
                sum += mat_1[i][k] * mat_2[k][j]
            row.append(sum)
        mat_f.append(row)
    print('classical output:',mat_f)

def main():
    matrix1 = [[1,2],[3,4]]
    matrix2 = [[4,5,6],[7,8,9]]
    classical(matrix1,matrix2)

main()