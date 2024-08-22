import {ErrorMessage, Field, Form, Formik} from "formik";
import * as Yup from "yup";
import {ColorRing} from "react-loader-spinner";
import {toast, ToastContainer} from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';
import {useNavigate} from "react-router-dom";

export function Create(){
    const navigate = useNavigate()

    return (
        <>
            <Formik initialValues={{
                name: 'C07_ABC',
                age: 15,
                gender: '1',
                languages: ['JAVA', 'C#']
            }}
            onSubmit={ (values, {setSubmitting}) => {
                setTimeout(() => {
                    console.log(values)
                    setSubmitting(false)
                    toast(`Student ${values.name} create OK.`);
                    navigate('/')
                }, 2000)
            }}
            validationSchema={Yup.object({
                name: Yup.string()
                    .required('Vui long nhap gia tri.')
                    .matches(/^C07_[a-z, A-Z]+$/),
                age : Yup.number('Vui long nhap so')
                    .min(10)
                    .max(100)
            })}
            >
                {
                    ({isSubmitting}) => (
                        <div className='container'>
                            <h1>Create Student</h1>
                            <Form>
                                <div className='mb-3'>
                                    <label htmlFor='studentName' className='form-label'>Name</label>
                                    <Field type='text' className='form-control' id='studentName'
                                           name='name'
                                    />
                                    <ErrorMessage name='name' component='span' className='form-error'/>
                                </div>
                                <div className='mb-3'>
                                    <label htmlFor='studentAge' className='form-label'>Age</label>
                                    <Field type='number' className='form-control' id='studentAge'
                                           name='age'
                                    />
                                    <ErrorMessage name='age' component='span' className='form-error'/>

                                </div>
                                <div className='mb-3'>
                                    <div className="form-check form-check-inline">
                                        <Field className="form-check-input" type="radio" id="inlineRadio1"
                                               value="1"
                                               name="gender"
                                        />
                                        <label className="form-check-label" htmlFor="inlineRadio1">Male</label>
                                    </div>
                                    <div className="form-check form-check-inline">
                                        <Field className="form-check-input" type="radio" id="inlineRadio2"
                                               value="0"
                                               name="gender"
                                        />
                                        <label className="form-check-label" htmlFor="inlineRadio2">FeMale</label>
                                    </div>
                                </div>

                                <label htmlFor='studentAge' className='form-label'>Languages</label>
                                <div className="form-check">
                                    <Field className="form-check-input" type="checkbox" value="C#" id="flexCheckDefault"
                                           name='languages'
                                    />
                                    <label className="form-check-label" htmlFor="flexCheckDefault">
                                        C#
                                    </label>
                                </div>
                                <div className="form-check">
                                    <Field className="form-check-input" type="checkbox" value="JAVA" id="cb1"
                                           name='languages'/>
                                    <label className="form-check-label" htmlFor="cb1">
                                        JAVA
                                    </label>
                                </div>
                                <div className="form-check">
                                    <Field className="form-check-input" type="checkbox" value="ReactJS" id="cb2"
                                           name='languages'/>
                                    <label className="form-check-label" htmlFor="cb2">
                                        ReactJS
                                    </label>
                                </div>

                                {
                                    isSubmitting ?
                                        <ColorRing
                                            visible={true}
                                            height="80"
                                            width="80"
                                            ariaLabel="color-ring-loading"
                                            wrapperStyle={{}}
                                            wrapperClass="color-ring-wrapper"
                                            colors={['#e15b64', '#f47e60', '#f8b26a', '#abbd81', '#849b87']}
                                        />
                                        :
                                        <button type='submit' className='btn btn-primary'>Submit</button>
                                }
                            </Form>
                        </div>
                    )
                }

            </Formik>


        </>
    )
}
