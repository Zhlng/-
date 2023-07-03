import {reactive,ref} from "vue";

interface User{
    email: string;
    password: string;
}
export const loginUser = reactive<User>({
    email: '',
    password: ''
})
// 校验规则
interface Rules{
    email: {
        required: boolean;
        type: string;
        message: string;
        trigger: string;
    }[];
    password: ({
        required: boolean;
        message: string;
        trigger: string;
        min?: undefined;
        max?: undefined;
    } | {
        min: number;
        max: number;
        message: string;
        trigger: string;
        required?: undefined;
    })[];
}
export const rules = reactive<Rules>({
    email: [
        {
            required: true,
            type: 'email',
            message: 'email格式错误',
            trigger: 'blur'
        }
    ],
    password: [
        { required: true, message: '密码不得为空', trigger: 'blur' },
        { min: 6, max: 30, message: '密码长度必须在6到30之间', trigger: 'blur' }
    ]
})