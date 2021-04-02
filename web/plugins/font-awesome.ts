import { library} from "@fortawesome/fontawesome-svg-core";
import { fas, faHome,faCode,faTools,faDatabase, faHeart,faSpinner,faPhotoVideo,faEnvelope} from "@fortawesome/free-solid-svg-icons";
import { faInstagram, faTwitter,faPython, faJava,faHtml5,faCss3,faAws,
    faWeixin,faGoogle,faLinkedin,faGithub
} from "@fortawesome/free-brands-svg-icons";
import FontAwesomeIcon from "../libs/FontAwesomeIcon.vue";

library.add(fas, faTwitter, faInstagram,faPython,faJava,faHtml5,faCss3,faAws,faWeixin,faGoogle,
    faCode,faTools,faHome,faDatabase,faHeart,faLinkedin,faSpinner,faPhotoVideo,faEnvelope,faGithub
);

export {FontAwesomeIcon};